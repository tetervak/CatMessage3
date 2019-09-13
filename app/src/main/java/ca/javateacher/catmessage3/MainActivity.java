/* Alex Tetervak, Sheridan College, Ontario */
package ca.javateacher.catmessage3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements InputFragment.InputListener {

  private static final String ABOUT_FRAGMENT = "aboutFragment";
  private static final String INPUT_FRAGMENT = "inputFragment";

  // to save the instance state
  private static final String MESSAGE = "message";

  private String mMessageText;
  private TextView mMessageView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    Button getMessageButton = findViewById(R.id.get_message_button);
    getMessageButton.setOnClickListener(v -> showInput());

    mMessageView = findViewById(R.id.message_text);

    if(savedInstanceState != null){
      mMessageText = savedInstanceState.getString(MESSAGE);
      mMessageView.setText(mMessageText);
    }else{
      mMessageText = getString(R.string.undefined);
    }
  }

  private void showInput() {
    InputFragment inputFragment = InputFragment.newInstance();
    inputFragment.show(getSupportFragmentManager(), INPUT_FRAGMENT);
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putString(MESSAGE, mMessageText);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    if (item.getItemId() == R.id.about) {
      AboutFragment aboutFragment = AboutFragment.newInstance();
      aboutFragment.show(getSupportFragmentManager(), ABOUT_FRAGMENT);
      return true;
    }
    return super.onOptionsItemSelected(item);
  }

  @Override
  public void updateMessage(String message) {
    mMessageText = message;
    mMessageView.setText(message);
  }
}
