package matcom.dcf.localbound;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by dfinlay on 31/07/15.
 */
public class BoundService extends Service{

    // Multiple clients can connect to a bound service
    // They must be started using a bind service
    // The first call to the service will trigger an onbind

    private final IBinder myBinder = new MyLocalBinder();
    // This returns a reference to the binder
     @Override
    public IBinder onBind(Intent arg0) {
        // TODO Auto-generated method stub
        return myBinder;
    }
    // Here we can define a list of public methods we can call from the
    // service
    public String getCurrentTime() {
        SimpleDateFormat dateformat =
                new SimpleDateFormat("HH:mm:ss MM/dd/yyyy", Locale.US);
        return (dateformat.format(new Date()));
    }
    // This returns a reference to the service
    public class MyLocalBinder extends Binder {
        BoundService getService() {
            return BoundService.this;
        }
    }



}
