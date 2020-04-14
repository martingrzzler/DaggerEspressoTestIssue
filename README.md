# DaggerEspressoTestIssue

This app just uses the network to retrieve a User object containing a name, username, and email. When you click the button on MainActivity
it executes this functionality. Just like in Mitch's course I'm using MVVM architecture. My next step was to make an Integration test
with a faked ApiSerice and Repository. When I don't design dagger to have subcomponents it all works fine. With Subcomponents, I can't make
it work because either it doesn't even build or it uses the production dependencies instead of the faked ones.

Just look at the two branches:

  - dagger_without_subcomponents_test_passes 
    - Works fine just like in Mitch's example
  
  - app_using_dagger_subcomponents_test_fails
    - Here I build a MainComponent together with the Appcomponent and it just doesn't work
