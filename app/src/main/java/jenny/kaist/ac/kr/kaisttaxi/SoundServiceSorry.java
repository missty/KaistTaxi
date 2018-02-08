package jenny.kaist.ac.kr.kaisttaxi;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class SoundServiceSorry extends Service {
    MediaPlayer player1;
    MediaPlayer player2;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        //player = MediaPlayer.create(this, R.raw.want_to_change); //select music file
        player1 = MediaPlayer.create(this, R.raw.sorry); //select music file
        player1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                player2 = MediaPlayer.create(SoundServiceSorry.this, R.raw.where_to);
                player2.start();
            }
        });
        player1.setLooping(false); //set looping
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        player1.start();
        return Service.START_NOT_STICKY;
    }

    public void onDestroy() {
        player1.stop();
        player1.release();
        if (player2 != null) {
            player2.stop();
            player2.release();
        }
        stopSelf();
        super.onDestroy();
    }

}