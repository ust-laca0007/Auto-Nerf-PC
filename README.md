# Auto-Nerf-PC
PC Project portion of AI &amp; Robotics Project

Michael LaCasse &amp; Sam LeVoir

## Software Requirements:
- Microsoft Kinect, with the SDK installed (get it [here](https://www.microsoft.com/en-us/download/details.aspx?id=44561)).
- EV3 with leJOS installed on it. You'll also need to install special drivers on your computer to connect to the EV3 over USB. Other methods of connection are more simple, but they are laggier, so we recommend using a USB connection for the the fastest speed. Directions on how to do that are [here](http://www.aplu.ch/home/ev3_inst.html) and [here](https://sourceforge.net/p/lejos/wiki/Windows%20Installation/), as well as under "Installing rndis".
- You'll also need the Win32 components for it, which you can download [here](http://www.lejos.org/ev3.php) (Click the "Downloads" link under "leJOS EV3" on the sidebar, and download the newest version).
- Eclipse with the leJOS plug-in installed. Directions on how to install the plugin are available [here](https://sourceforge.net/p/lejos/wiki/Installing%20the%20Eclipse%20plugin/).

## Installing rndis
This driver allows a PC to communicate with an EV3 with leJOS over USB.
1. Download rndis.zip from http://www.aplu.ch/home/ev3_inst.html and extract it.
2. Right-click on "rndis.inf" in the extracted folder. Select "Install". A pop-up should inform you that "The operation completed successfully."
3. To verify the driver is installed and working, plug in an EV3 with leJOS into the computer, and open up the Device Manager. Under "Network adapters," you should see a device called "USB Ethernet/RNDIS Gadget."

## Project Directions
1. Clone both [Auto-Nerf-Turret](https://github.com/ust-laca0007/Auto-Nerf-Turret) and [Auto-Nerf-PC](https://github.com/ust-laca0007/Auto-Nerf-PC).
2. Boot up leJOS on the EV3, and plug the EV3 into your motors and the computer. Check the IP address of the EV3, and make sure that the ip address in ip.properties matches it.
3. In Eclipse, start Turret.java from the Auto-Nerf-Turret project. This will make Eclipse leJOS plugin send the program to the EV3 after it compiles it, where it will wait for the PC to connect to it.
4. In Eclipse, start KinectViewerApp.java from the Auto-Nerf-PC project. This will display a view of what the Kinect sees, as well as open a connection to the EV3. When the Kinect detects someone's "skeleton" (the viewer will show a red stick figure on their body), the KinectViewerApp will start sending targetting data to the EV3, and the turret will track the user. When the user stands still for a moment or two, the turret detects this and attempts to shoot them.
5. When you're done shooting people, close out of the KinectViewerApp on the computer. The EV3 will detect that the computer has disconnected, and will stop moving the turret. You can press the middle button the turret to reset it, so that you can restart the KinectViewerApp and reconnect to the EV3, or press any other button to quit out of Turret.java.

That's all there is to it.

## Bugs
leJOS programs have to be compiled for Java 1.7. This should be fairly easy in Eclipse, but I wasn't able to get it working on second computer that I tried to run this on. Eclipse or the leJOS plug wasn't picking up the 1.7 settings, and was compiling Turret.java for Java 1.8, which resulted in leJOS refusing to run the application (in spite of the the fact that the [version number](https://en.wikipedia.org/wiki/Java_class_file) was literally the only difference between the correct and incorrect files). I can't debug this now, but I have a working Turret.jar in the Auto-Nerf-Turret repo.

## Useful resources
- Auto-Nerf-PC is heavily based on the Kinect Viewer App from the J4K examples, available [here](https://research.dwi.ufl.edu/ufdw/download.php). Auto-Nerf-PC also includes the J4K libraries, which are needed to connect to the Kinect with Java.
- When developing Auto-Nerf-Turret, we frequently referred to the Java API documentation for leJOS, which is available [here](http://www.lejos.org/ev3/docs/).
