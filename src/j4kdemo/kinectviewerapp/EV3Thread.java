package j4kdemo.kinectviewerapp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.Properties;

import edu.ufl.digitalworlds.j4k.Skeleton;

public class EV3Thread implements Runnable {
		
		public class EV3Conn {
			
			private Socket s;
			private ObjectOutputStream oos;
			private boolean connected;
			
			public EV3Conn() throws IOException {
				this.connect();
			}
			
			private void connect() throws IOException {
				Properties p = new Properties();
				p.load(new FileInputStream("ip.properties"));
				String ip = p.getProperty("ip");
				System.out.println(ip);
				this.s = new Socket(ip, 1337);
				this.oos = new ObjectOutputStream(s.getOutputStream());
				this.connected = true;
			}
			
			public void write(double[] d) {
				try {
					if (!this.connected)
						this.connect();
					oos.writeObject(d);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			public void close() {
				this.connected = false;
				try {
					oos.close();
					s.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		Kinect kinect;
		
		public EV3Thread(Kinect kinect) {
			this.kinect = kinect;
		}
		
		@Override
		public void run() {
			EV3Conn c;
			
			try {
				c = new EV3Conn();
			} catch (IOException e1) {
				e1.printStackTrace();
				return;
			}
			
			while (true) {
				try { Thread.sleep(500); } catch (Exception e) {}

				boolean moved = false;
				
				Skeleton[] s = kinect.getSkeletons();
				if (s==null) continue;
				for(int i=0;i<s.length;i++)
				{
					if (s[i]==null) continue;
					double[] arr = s[i].get3DJoint(1);

					if (s[i].getTimesDrawn()<=10 && s[i].isTracked()) {
						System.out.println(Arrays.toString(arr));
						System.out.println(s[i].getPlayerID());
						if (!moved) {
							c.write(arr);
							moved = true;
						}
					}
				}
			}
		}
	}
