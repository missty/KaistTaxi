package jenny.kaist.ac.kr.kaisttaxi;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class SoundServiceOnMove extends Service {
    MediaPlayer player;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        //player = MediaPlayer.create(this, R.raw.want_to_change); //select music file
        player = MediaPlayer.create(this, R.raw.on_move); //select music file
        player.setLooping(false); //set looping
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        player.start();
        return Service.START_NOT_STICKY;
    }

    public void onDestroy() {
        player.stop();
        player.release();
        stopSelf();
        super.onDestroy();
    }

}