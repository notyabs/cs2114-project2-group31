# cs2114-project2-group31
Replicating Spotify library and playlist functionality using Linked Chain implementation.


## Reflection

*What changed from your specification? Classes, method signatures, where validation lives, test cases — what did the spec say, what did you build instead, and why?*

Our specification described a complete application with users, libraries, playlists, songs, and a console menu. This app slice implements the Playlist class, which stores a playlist name and a LinkedChain<Song>. It includes methods to add, remove, and retrieve songs, check the song count, calculate total runtime, and clear a playlist. We also implemented the stretch methods moveSong(int currentIndex, int newIndex) and swapSongs(int index1, int index2). The specification allowed removal by position or song name, but this slice provides removeSong(Song song), which removes a matching song object. We planned to prevent duplicate songs, but addSong(Song song) currently allows them. Playlist-name and null-song validation live in Playlist, while index validation for getSong comes from LinkedChain. Song-field validation and console input handling are not shown in this slice.


*What changed in the LinkedChain? Anything you added to or modified in the provided class and why your application needed it, or that you used it unchanged.*

We used the provided LinkedChain unchanged. Its existing methods support the playlist operations we needed. We use addToEnd to preserve insertion order and toArray to calculate total runtime and rearrange songs. Moving or swapping songs works by rearranging an array, clearing the chain, and adding the songs back in the new order.


*What happened to your unknowns? Of the things you listed in your scope as not knowing how to do, which did you figure out, and which are still open?*

We figured out how to organize songs within each playlist: each Playlist contains a LinkedChain<Song>. We also worked out how to move and swap songs using the chain’s existing methods. Connecting libraries to users and keeping their data between program runs remain open because this slice does not implement users or persistent storage.


*What doesn't work yet? MVP features, bad-input cases, or tests that are missing or failing in this prototype.*

User and library management, a console menu, playlist display, formatted song information, and removal by a user entered name or position are still missing. Song and artist searches are also not implemented. The class rejects empty playlist names, null songs, and invalid move or swap positions, but a console interface still needs to catch errors and prompt users again.

## Next Steps
*What is left to finish the MVP? The remaining features and fixes, in the order you will do them.*
1. Finish the Song class with title, artist, genre, and duration in whole seconds. Reject empty titles and artist names and nonpositive durations.
2. Implement the library and User classes so each user has a separate library and can create and access playlists.
3. Add duplicate checks to match our original specification. Define how songs are compared so removal and duplicate detection behave consistently.
4. Implement removal by displayed song position.
5. Build the console menu for creating playlists, adding and removing songs, and viewing the library.
6. Display song details, song count, and formatted total runtime.
7. Handle invalid menu input and positions without crashing, then test the complete workflow.


*Which stretch goals will you attempt? The ones from your scope you are committing to, and the ones you are dropping.*

We will finish and test moving and swapping songs, since both methods are already implemented in the playlist slice. We are dropping searching by song title or artist from this version so we can prioritize completing the MVP.


*What new tests will you need? The methods and bad-input cases the added work must cover.*

We will need tests for the remaining user and library features, including creating playlists, adding and retrieving them, and keeping each user’s library separate.

*Who does what? Which team member owns each remaining item.*
Yabsira - Finish implementing/testing stretch goals
Ujay - Implement library class/tests
Andrew - Implement user class/build console menu

## Attribution

| Class | Contributor | Method |
|-------|-------------|--------|
| Playlist | Yabsira | GenAI drafted class |
| PlaylistTest | Andrew, Yabsira | Gen AI assisted in test case formulation, test case revision  |
| Song | Andrew | Partially GenAI drafted *last method* |
| SongTest | Andrew, Yabsira | Gen AI assisted in test case formulation, test case revision |
| PlaylistSimulation | Ujay, Yabsira | GenAI assisted in handling User input and displaying state of playlist after changes |
