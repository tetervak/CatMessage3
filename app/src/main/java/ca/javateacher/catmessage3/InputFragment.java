/* Alex Tetervak, Sheridan College, Ontario */
package ca.javateacher.catmessage3;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;

public class InputFragment extends DialogFragment {

  // the index of the selected message
  private int mMessageInd = 1;

  public interface InputListener {
    void updateMessage(String text);
  }
  private InputListener mInputListener;

  public InputFragment() {
    // Required empty public constructor
  }

  public static InputFragment newInstance(){
    return new InputFragment();
  }

  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
    if(context instanceof InputListener){
        mInputListener = (InputListener) context;
    }else{
        throw new RuntimeException(context.toString()
                + " must implement InputFragment.InputListener");
    }
  }

  @Override
  public void onDetach() {
    super.onDetach();
    mInputListener = null;
  }

  @SuppressWarnings("ConstantConditions")
  @Override
  @NonNull
  public Dialog onCreateDialog(@Nullable Bundle bundle) {

    // create a new AlertDialog Builder
    AlertDialog.Builder builder =
        new AlertDialog.Builder(getActivity());
    builder.setTitle(R.string.select_message);
    builder.setSingleChoiceItems(R.array.cat_messages,
        mMessageInd, new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
            mMessageInd = which;
          }
        });

    builder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int button) {
        if (mInputListener != null) {
          String message = getResources().getStringArray(R.array.cat_messages)[mMessageInd];
          mInputListener.updateMessage(message);
        }
      }
    });

    builder.setNegativeButton(android.R.string.no, null);
    return builder.create(); // return the AlertDialog
  }


}
