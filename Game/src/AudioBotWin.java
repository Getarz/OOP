import java.io.File;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class AudioBotWin{
	File TSover;
	AudioInputStream stream;
	AudioFormat format;
	DataLine.Info info;
	Clip clip;
	public AudioBotWin () {
		try {
			File initailFile = new File(System.getProperty("user.dir")	
					+ File.separator + "BotWin.wav");
			stream = AudioSystem.getAudioInputStream(initailFile);
			format = stream.getFormat();
			info = new DataLine.Info(Clip.class, format);
			clip = (Clip) AudioSystem.getLine(info);
			clip.open(stream);
			clip.start();
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		} 
		catch (Exception e) {}
	}
}