import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class AudioWin {
	File TSover;
	AudioInputStream stream;
	AudioFormat format;
	DataLine.Info info;
	Clip clip;
	public AudioWin(String string) {
		clip.stop();
	}
	public AudioWin() {
		
	}
	void Win_100Year () {
		try {
			File initailFile = new File(System.getProperty("user.dir")	
					+ File.separator + "Win_100Year.wav");
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
	void Win_Ainong () {
		try {
			File initailFile = new File(System.getProperty("user.dir")	
					+ File.separator + "Win_Ainong.wav");
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
	void Win_Guzeanpai () {
		try {
			File initailFile = new File(System.getProperty("user.dir")	
					+ File.separator + "Win_Guzeanpai.wav");
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
	void Win_hudMaMai () {
		try {
			File initailFile = new File(System.getProperty("user.dir")	
					+ File.separator + "Win_hudMaMai.wav");
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
	void Win_soypisoy () {
		try {
			File initailFile = new File(System.getProperty("user.dir")	
					+ File.separator + "Win_soypisoy.wav");
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
	void Win_walkLong () {
		try {
			File initailFile = new File(System.getProperty("user.dir")	
					+ File.separator + "Win_walkLong.wav");
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
	void Win_maidiadag22 () {
		try {
			File initailFile = new File(System.getProperty("user.dir")	
					+ File.separator + "Win_maidiadag22.wav");
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
	void Lost_EatGrab () {
		try {
			File initailFile = new File(System.getProperty("user.dir")	
					+ File.separator + "Lost_EatGrab.wav");
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
	void Lost_dakEveryDay2 () {
		try {
			File initailFile = new File(System.getProperty("user.dir")	
					+ File.separator + "Lost_dakEveryDay2.wav");
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
	void Lost_DakEveryDay () {
		try {
			File initailFile = new File(System.getProperty("user.dir")	
					+ File.separator + "Lost_DakEveryDay.wav");
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
	void Lost_maidaiDak () {
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
	void Lost_janow () {
		try {
			File initailFile = new File(System.getProperty("user.dir")	
					+ File.separator + "Lost_janow.wav");
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
	void Lost_nacom () {
		try {
			File initailFile = new File(System.getProperty("user.dir")	
					+ File.separator + "Lost_nacom.wav");
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
	void Lost_tungjai () {
		try {
			File initailFile = new File(System.getProperty("user.dir")	
					+ File.separator + "Lost_tungjai.wav");
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
	void StarGame () {
		try {
			File initailFile = new File(System.getProperty("user.dir")	
					+ File.separator + "StarGame.wav");
			stream = AudioSystem.getAudioInputStream(initailFile);
			format = stream.getFormat();
			info = new DataLine.Info(Clip.class, format);
			clip = (Clip) AudioSystem.getLine(info);
			clip.open(stream);
			clip.start();
		} 
		catch (Exception e) {}
	}
}
