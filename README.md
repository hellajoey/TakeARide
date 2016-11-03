# TakeARide

- Went with a 3-Activity architecture. I think this is a fine choice but it did lead to the following issues which should be cleaned up:
- 1) Right now I’m just refetching the data on screen 2 and then passing the relevant data forward by value to screen 3. The app should be passing all relevant data selections forward as parcelables but that’s for V2.
- 2) Using an ActivityForResult to go up and down the activity list is a little sloppy but until there is further clarification about what should happen after a purchase it works fine enough.

- It would probably be nice to send the purchase information back to be displayed in the thank you message but that’s for V2. Currently logging the purchase info to the console.

- The unit tests don’t cover everything they probably should but that’s for V2.

- Would consider moving some of the click logic out of the activities and into the presenters. Also for V2.


			

