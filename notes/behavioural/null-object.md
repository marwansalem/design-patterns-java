When component A uses component B,
it assumes that B is non-null.
* You inject B, not some Option\<B\> type (if dependency injection is used)
* A does not check for null on every call

A is fixed, you cannot tell it to not use an instance of B
* Its used is hard-coded

Solution build a no-op, non-functioning inheritor of B (Or an interface that B implements) and pass it into A.

Null Object: is a no-op object that conforms to the required interface, satisfying a dependency requirement of some other object.