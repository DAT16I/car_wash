# General

Nice separation of concerns, easy flow too follow and sporadic comments are good.

You are not doing OOP (Object Oriented Programming) though. You have nicely
separated the concerns of the application into good named files but your
`Customer.java` should be a blueprint class and all the fields should be
private and utilize getters and setters. Right now it's just static values,
which makes this application almost impossible to scale later on.

if this was a C or C++ program this structure would be fine I guess but now we
are in OOP land and have to follow those conventions that comes with that.
That's what you curriculum is about. Learning OOP programming while using Java.
