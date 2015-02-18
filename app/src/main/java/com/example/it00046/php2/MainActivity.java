package com.example.it00046.php2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.loopj.android.http.*;

import org.apache.http.Header;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void btnAcceptarOnClick(View view){

        /*

         Exemple 1


        RequestParams params = new RequestParams();
        params.put("usuari", "james");
        params.put("email", "123456");


        TwitterRestClient.post("prova.php", params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                // If the response is JSONObject instead of expected JSONArray
                Log.i("Hola", "");
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray timeline) {
                // Pull out the first event on the public timeline
                //JSONObject firstEvent = timeline.get(0);
                //String tweetText = firstEvent.getString("text");
            }
        });
        */

        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.put("usuari", "james");
        params.put("email", "123456");
        client.post("http://bodina.virtuol.com/prova.php", params, new TextHttpResponseHandler() {

            @Override
            public void onStart() {
                // called before request is started
                Log.i("Hola", "Start");
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.i("Hola", "Error");
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Log.i("Hola", "Ok " + responseString);
            }

            @Override
            public void onFinish(){

            }
        });

        // Cridant a una classe estatica

        RequestParams params2 = new RequestParams();
        params2.put("usuari", "james");
        params2.put("email", "123456");
        php.post("prova.php", params2, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.i("Hola", "Error");
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Log.i("Hola", "Ok " + responseString);
            }
        });
           /*
           AsyncHttpResponseHandler() {
            @Override
            public void onStart() {
                // called before request is started
                Log.i("Hola", "Start");
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] response) {
                // called when response HTTP status is "200 OK"
                Log.i("Hola", "OK " + response );
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
                Log.i("Hola", "KO " + errorResponse);
            }

            @Override
            public void onRetry(int retryNo) {
                // called when request is retried
                Log.i("Hola", "Retry?");
            }

        });
*/

    }

}
