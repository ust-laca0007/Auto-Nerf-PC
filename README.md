# Auto-Nerf-PC
PC Project portion of AI &amp; Robotics Project

Michael LaCasse

Sam LeVoir

## Project Directions
1. Clone both [Auto-Nerf-Turret](https://github.com/ust-laca0007/Auto-Nerf-Turret) and [Auto-Nerf-PC](https://github.com/ust-laca0007/Auto-Nerf-PC) onto a computer with Eclipse installed. You will also need leJOS EV3 plugin for Eclipse (installation directions [here](https://sourceforge.net/p/lejos/wiki/Installing%20the%20Eclipse%20plugin/)).
2. Install leJOS onto the EV3 that you'll be using, and install the needed drivers on your computer to connect to the EV3 over USB. (Warning: other methods of connection will be easier, but they are laggier, so we reccommend using a USB connection for the the fastest speed). Directions on how to do that are [here](http://www.aplu.ch/home/ev3_inst.html) and [here](https://sourceforge.net/p/lejos/wiki/Windows%20Installation/).
3. Boot up leJOS on the EV3, and plug the EV3 into your motors and the computer.
4. In Eclipse, start Turret.java from the Auto-Nerf-Turret project. This will make Eclipse leJOS plugin send the program to the EV3 after it compiles it, where it will wait for the PC to connect to it.
5. In Eclipse, start KinectViewerApp.java from the Auto-Nerf-PC project. This will display a view of what the Kinect sees, as well as open a connection to the EV3. When the Kinect detects someone's "skeleton" (the viewer will show a red stick figure on their body), the KinectViewerApp will start sending targetting data to the EV3, and the turret will track the user. When the user stands still for a moment or two, the turret detects this and attempts to shoot them.
6. When you're done shooting people, close out of the KinectViewerApp on the computer. The EV3 will detect that the computer has disconnected, and will stop moving the turret. You can press the middle button the turret to reset it, so that you can restart the KinectViewerApp and reconnect to the EV3, or press any other button to quit out of Turret.java.

That's all there is to it.

## Useful resources
- Auto-Nerf-PC is heavily based on the Kinect Viewer App from the J4K examples, available [here](https://research.dwi.ufl.edu/ufdw/download.php). Auto-Nerf-PC also includes the J4K libraries, which are needed to connect to the Kinect with Java.
- When developing Auto-Nerf-Turret, we frequently referred to the API documentation for leJOS, which is available [here](http://www.lejos.org/ev3/docs/).
