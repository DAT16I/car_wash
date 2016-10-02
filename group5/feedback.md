# General

When trying to compile I get two errors:

```
SaveLoad.java:57: error: cannot find symbol
      PrintStream output = new PrintStream(new File(outputPath));
                                                    ^
  symbol:   variable outputPath
  location: class SaveLoad
group5/SaveLoad.java:108: error: cannot find symbol
      PrintStream output = new PrintStream(new File(outputPath));
                                                    ^
  symbol:   variable outputPath
  location: class SaveLoad
2 errors
```

I think you meant to put in the global variables `customerPath` and `washPath`
and `outputPath` is therefore deprecated.
This probably happened when you went from one file with all the data too two
separate data files. Did it compile for you? Or is this an old version I have?

Watch out with naming your classes like methods/functions. `CheckAccount` is an
action and so is `CarWashChooseAnOption`. I get why it is done but try and
follow OOP rules and make machines aka. blackboxes. `CheckAccount` could be
`AccountChecker` and `CarWashChooseAnOption` could be `CarWashOptionPicker`.
The code is just as valid, but valid code is not enough and is not even
important if it's expensive, hard to read code that does not follow conventions.
`ArrayObject` is also dangerous because it could easily collide with something
more Java generic. It's not very descriptive of what it consists of. A good
pointer is if you can't figure out a good name for a thing it might be too
general and you need to separate your concerns into multiple files.
There is nothing wrong with having a lot of different files as long as it makes
sense!

## SaveLoad.java

Very nice usage of a general helper class with static methods.
Naming is good and the flow is easy too follow.

* Line 9:

  There is no need to make an empty constructor! Java implicitly gives you an
  empty constructor so no need for that.

## SaveMain.java

What's the purpose of this file? Testing?

## WashType.java

Naming is a bit off here.
Instead of WashType for the class more appropriate would be `Wash` and then
instead of the filed `washName` I would name it `washType`. This generalizes
it more efficiently and allows for better abstraction later on.
You aren't calling you `Customer`, `CustomerType` so please keep you naming
consistent.

* Line 6:

  Again, no need for an empty constructor.
  Nice use of `System.getProperty("line.separator")`

## Customer.java

* Line 6:

  Empty constructor.
