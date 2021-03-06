## Philosophy
**DGUI** was created to fulfill the need for a beginner-friendly GUI toolkit that upholds (or in other words does not sacrifice) certain principles. These principles are outlined below as our **Goals**.

We aim to...

1. Be simple, clutter-free, and easy-to-pickup for beginners
    1. We minimize boilerplate code to get the GUI up and running
    2. We minimize clutter in IDE suggestions, exposing very few public methods -- only the ones that will be useful to beginners
    3. We avoid confusing, advanced concepts like anonymous inner classes that vanilla Swing requires
    4. We try our best (within the limits of Swing) to make the UI non-ugly, with sane padding, etc.

2. Be semi-declarative
    1. Our layout system through `HPane` and `VPane` allows flexible grid-like layouts to be intuitively laid out in code (unlike other so-called beginner-friendly toolkits which use a confusing index based grid system which requires code that look nothing like the final layout)

3. Be educational
    1. Our code closely follows the Object-Oriented paradigm, and the simpler classes may be used to showcase concepts like Interfaces, Inheritance, and Polymorphism
    2. Our code encourages the use of standard constructors, rather than magic factory methods that happen to also require layout (see *Goal 4ii*)
    3. The base toolkit intentionally defers data formatting to the user -- all of our widgets accept and expose data as `String`s only. We believe it is beneficial for begineers to learn the parsing functions like `Integer.parseInt()` and their associated exceptions, etc.

4. Be flexible
    1. We do not want to limit potentially-advanced users from either extending **DGUI** or integrating **DGUI** into existing Swing solutions.
    2. The toolkit is structured as a whole to be easy to extend: implementing additional widgets by simply wrapping other Swing components is easy.
    3. All `Widget` classes expose the internal Swing `JComponent` through the method `getInternal()` to facilitate integration with existing Swing code.

5. Adhere to commonly held paradigms in GUI programming
    1. Our bindings (e.g. button click callbacks), although intuitive thanks to Reflection-based logic, are explicit and similar in syntax and concept to other GUI toolkits, including raw Swing's Listener-based system, GTK's signal-based system, HTML+Javascript's callback system, and Cocoa's action-based system. (unlike other so-called beginner-friendly toolkits that magically call a predestined method)
    2. We separate the concerns of Layout and Widgets (unlike other so-called beginner-friendly toolkits which confound the two in the name of simplicity)
    3. We separate the concerns of Widget and Data -- the widgets provided by the toolkit should not be responsible for providing methods for formatting specific types of data (see also *Goal 3iii*)

6. Be Open: **DGUI** is released under the MIT License

These Goals are showcased in a comparison to [BreezyGUI](http://mathbits.com/MathBits/Java/UsingBreezyGUI/ControllingWindow.htm), a different so-called beginner-friendly toolkit, in the [examples](src/com/jeromecompsci/dgui/examples).
