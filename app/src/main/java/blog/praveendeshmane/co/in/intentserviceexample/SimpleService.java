package blog.praveendeshmane.co.in.intentserviceexample;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.os.SystemClock;
import android.text.format.DateFormat;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class SimpleService extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    //
    public static final String PARAM_IN_MSG = "imsg";
    public static final String PARAM_OUT_MSG = "omsg";

    public SimpleService() {
        super("SimpleService");
    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */

    /**
     * Starts this service to perform action Baz with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method

    protected void onHandleIntent(Intent intent) {
        String msg = intent.getStringExtra(PARAM_IN_MSG);
        String resultTxt = msg + " "
                + DateFormat.format("MM/dd/yy h:mmaa", System.currentTimeMillis());

        Intent broadcastIntent = new Intent();
        broadcastIntent.setAction(MainActivity.ResponseReceiver.ACTION_RESP);
        broadcastIntent.addCategory(Intent.CATEGORY_DEFAULT);
        broadcastIntent.putExtra(PARAM_OUT_MSG, resultTxt);
        sendBroadcast(broadcastIntent);


    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */

}
