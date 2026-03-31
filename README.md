## CS4A Project 1
In this project we created a abstract base class called SmartHome. From there we created three sub classes 
called UtilityDevices, SecurityDevices, and ComfortDevices which extended from SmartHome. We created a few 
more specific subclasses that extended from the previously stated classes such as Television which extended 
from ComfortDevices. With all these classes we also made a permissions interface that was used by the
SecurityDevices which checked if certain users were allowed to access Security Devices or not. We 
implemented two custom Exception classes. The first one which was InvalidPermission which was thrown if a 
person tried accessing a security device while not having the proper permission. The second one which was
DeviceNotOn was thrown if a user tried using a device that was not on. The main program allowed a user to
check the status of different devices, look at all the information of a specific device, as well as toggle 
certain features on or off however they needed.
