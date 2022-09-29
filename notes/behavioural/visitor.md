Allow adding extra behaviors to entire hierarchies of classes

We do not want to keep modifying every class in the hierarchy.
Need to access non-common aspects of these classes.
Avoid type checks, instanceof


A component visitor is allowed to traverse the entire hierarchy.
Implemented by propagating a single `visit()` method throughout the hierarchy.