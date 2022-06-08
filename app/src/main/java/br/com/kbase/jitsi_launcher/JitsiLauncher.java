package br.com.kbase.jitsi_launcher;

import androidx.appcompat.app.AppCompatActivity;

import org.jitsi.meet.sdk.JitsiMeet;
import org.jitsi.meet.sdk.JitsiMeetActivity;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class JitsiLauncher {

    private String room, url;
    private boolean useDeafult = true;

    public void setDefaultConfigs(){
        URL serverUrl;
        try {

            if(url != null)
                serverUrl = new URL(url);
            else
                serverUrl = new URL("https://meet.jit.si");

            JitsiMeetConferenceOptions defaultOptions =
                    new JitsiMeetConferenceOptions.Builder()
                            .setServerURL(serverUrl)
                            .build();

            JitsiMeet.setDefaultConferenceOptions(defaultOptions);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public JitsiLauncher(){

        url = null;

        setDefaultConfigs();
    }

    public void launch(AppCompatActivity context){

        if(room != null){

            JitsiMeetConferenceOptions options = new JitsiMeetConferenceOptions.Builder()
                    .setRoom(this.room)
                    .build();
            JitsiMeetActivity.launch(context, options);
        }
    }

    public void setRoom(String room){
        this.room = room;
    }



}
