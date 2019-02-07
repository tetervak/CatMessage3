/* Alex Tetervak, Sheridan College, Ontario */
package ca.javateacher.catmessage3;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;

public class AboutFragment extends DialogFragment {

  public AboutFragment() {
    // Required empty public constructor
  }

  public static AboutFragment newInstance(){
    return new AboutFragment();
  }

  @NonNull
  @Override
  public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

    // create a new AlertDialog Builder
    AlertDialog.Builder builder =
        new AlertDialog.Builder(getActivity());

    builder.setTitle(R.string.app_name);
    builder.setMessage(R.string.author);

    builder.setPositiveButton(android.R.string.ok, null);

    return builder.create();
  }
}