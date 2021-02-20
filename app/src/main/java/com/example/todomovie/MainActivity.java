package com.example.todomovie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public List<String> list=new ArrayList<>(Arrays.asList("Black Panther", "Avengers: Infinity War", "Incredibles 2", "Jurassic World: Fallen Kingdom", "Deadpool 2", "Mission: Impossible - Fallout", "Ant-Man and the Wasp", "Solo: A Star Wars Story", "Venom", "A Star is Born ", "Star Wars: The Last Jedi", "Beauty and the Beast ", "Wonder Woman", "Jumanji: Welcome to the Jungle", "Guardians of the Galaxy Vol. 2", "Spider-Man: Homecoming", "It", "Thor: Ragnarok", "Despicable Me 3", "Justice League", "Rogue One: A Star Wars Story", "Finding Dory", "Captain America: Civil War", "The Secret Life of Pets", "The Jungle Book ", "Deadpool", "Zootopia", "Batman v Superman: Dawn of Justice", "Suicide Squad", "Sing", "Star Wars: The Force Awakens", "Jurassic World", "Avengers: Age of Ultron", "Inside Out", "Furious 7", "Minions", "The Hunger Games: Mockingjay - Part 2", "The Martian", "Cinderella", "Spectre", "Transformers: Age of Extinction", "The Hobbit: The Battle of the Five Armies", "Guardians of the Galaxy", "Maleficent", "The Hunger Games: Mockingjay - Part 1", "X-Men: Days of Future Past", "Captain America: The Winter Soldier", "The Amazing Spider-Man 2", "Dawn of the Planet of the Apes", "Interstellar", "Frozen", "Iron Man 3", "Despicable Me 2", "The Hobbit: The Desolation of Smaug", "The Hunger Games: Catching Fire", "Fast & Furious 6", "Monsters University", "Gravity", "Man of Steel", "Thor: The Dark World", "The Avengers", "Skyfall", "The Dark Knight Rises", "The Hobbit: An Unexpected Journey", "Ice Age: Continental Drift", "The Twilight Saga: Breaking Dawn - Part 2", "The Amazing Spider-Man", "Madagascar 3: Europe's Most Wanted", "The Hunger Games", "Men in Black 3", "Harry Potter and the Deathly Hallows - Part 2", "Transformers: Dark of the Moon", "Pirates of the Caribbean: On Stranger Tides", "The Twilight Saga: Breaking Dawn - Part 1", "Mission: Impossible - Ghost Protocol", "Kung Fu Panda 2", "Fast Five", "The Hangover Part II", "The Smurfs", "Cars 2", "Toy Story 3", "Alice in Wonderland", "Harry Potter and the Deathly Hallows - Part 1", "Inception", "Shrek Forever After", "The Twilight Saga: Eclipse", "Iron Man 2", "Tangled", "Despicable Me", "How to Train Your Dragon", "Avatar", "Harry Potter and the Half-Blood Prince", "Ice Age: Dawn of the Dinosaurs", "Transformers: Revenge of the Fallen", "2012", "Up", "The Twilight Saga: New Moon", "Sherlock Holmes", "Angels & Demons", "The Hangover", "The Dark Knight", "Indiana Jones and the Kingdom of the Crystal Skull", "Kung Fu Panda", "Hancock", "Mamma Mia!", "Madagascar: Escape 2 Africa", "Quantum of Solace", "Iron Man", "WALL-E", "The Chronicles of Narnia: Prince Caspian", "Pirates of the Caribbean: At World's End", "Harry Potter and the Order of the Phoenix", "Spider-Man 3", "Shrek the Third", "Transformers", "Ratatouille", "I Am Legend", "The Simpsons Movie", "National Treasure: Book of Secrets", "300", "Pirates of the Caribbean: Dead Man's Chest", "The Da Vinci Code", "Ice Age: The Meltdown", "Casino Royale", "Night at the Museum", "Cars", "X-Men: The Last Stand", "Mission: Impossible III", "Superman Returns", "Happy Feet", "Harry Potter and the Goblet of Fire", "Star Wars Episode III: Revenge of the Sith", "The Chronicles of Narnia: The Lion", " the Witch and the Wardrobe", "War of the Worlds", "King Kong", "Madagascar", "Mr. & Mrs. Smith", "Charlie and the Chocolate Factory", "Batman Begins", "Hitch", "Shrek 2", "Harry Potter and the Prisoner of Azkaban", "Spider-Man 2", "The Incredibles", "The Passion of the Christ", "The Day After Tomorrow", "Meet the Fockers", "Troy", "Shark Tale", "Ocean's Twelve", "The Lord of the Rings: The Return of the King", "Finding Nemo", "The Matrix Reloaded", "Pirates of the Caribbean: The Curse of the Black Pearl", "Bruce Almighty", "The Last Samurai", "Terminator 3: Rise of the Machines", "The Matrix Revolutions", "X2", "Bad Boys II", "The Lord of the Rings: The Two Towers", "Harry Potter and the Chamber of Secrets", "Spider-Man", "Star Wars Episode II: Attack of the Clones", "Men in Black II", "Die Another Day", "Signs", "Ice Age", "My Big Fat Greek Wedding", "Minority Report", "Harry Potter and the Sorcerer's Stone", "The Lord of the Rings: The Fellowship of the Ring", "Monsters", " Inc.", "Shrek", "Ocean's Eleven", "Pearl Harbor", "The Mummy Returns", "Jurassic Park III", "Planet of the Apes", "Hannibal", "Mission: Impossible II", "Gladiator", "Cast Away", "What Women Want", "Dinosaur", "How the Grinch Stole Christmas", "Meet the Parents", "The Perfect Storm", "X-Men", "What Lies Beneath", "Star Wars Episode I: The Phantom Menace", "The Sixth Sense", "Toy Story 2", "The Matrix", "Tarzan", "The Mummy", "Notting Hill", "The World Is Not Enough", "American Beauty", "Austin Powers: The Spy Who Shagged Me", "Armageddon", "Saving Private Ryan", "Godzilla", "There's Something About Mary", "A Bug's Life", "Deep Impact", "Mulan", "Dr. Dolittle", "Shakespeare in Love", "Lethal Weapon 4", "Titanic", "The Lost World: Jurassic Park", "Men in Black", "Tomorrow Never Dies", "Air Force One", "As Good as It Gets", "Liar Liar", "My Best Friend's Wedding", "The Fifth Element", "The Full Monty", "Independence Day", "Twister", "Mission: Impossible", "The Rock", "The Hunchback of Notre Dame", "101 Dalmatians", "Ransom", "The Nutty Professor", "Jerry Maguire", "Eraser", "Die Hard with a Vengeance", "Toy Story", "Apollo 13", "GoldenEye", "Pocahontas", "Batman Forever", "Seven", "Casper", "Waterworld", "Jumanji", "The Lion King", "Forrest Gump", "True Lies", "The Mask", "Speed", "The Flintstones", "Dumb and Dumber", "Four Weddings and a Funeral", "Interview with the Vampire: The Vampire Chronicles", "Clear and Present Danger", "Jurassic Park", "Mrs. Doubtfire", "The Fugitive", "Schindler's List", "The Firm", "Indecent Proposal", "Cliffhanger", "Sleepless in Seattle", "Philadelphia", "The Pelican Brief", "Aladdin", "The Bodyguard", "Home Alone 2: Lost in New York", "Basic Instinct", "Lethal Weapon 3", "Batman Returns", "A Few Good Men", "Sister Act", "Bram Stoker's Dracula", "Wayne's World", "Terminator 2: Judgment Day", "Robin Hood: Prince of Thieves", "Beauty and the Beast", "Hook", "The Silence of the Lambs", "JFK", "The Addams Family", "Cape Fear", "Hot Shots!", "City Slickers", "Ghost", "Home Alone", "Pretty Woman", "Dances with Wolves", "Total Recall", "Back to the Future Part III", "Die Hard 2", "Presumed Innocent", "Teenage Mutant Ninja Turtles", "Kindergarten Cop", "Indiana Jones and the Last Crusade", "Batman", "Back to the Future Part II", "Look Who's Talking", "Dead Poets Society", "Lethal Weapon 2", "Honey", " I Shrunk the Kids", "Ghostbusters II", "The Little Mermaid", "Born on the Fourth of July", "Rain Man", "Who Framed Roger Rabbit", "Coming to America", "Big", "Twins", "Crocodile Dundee II", "Die Hard", "The Naked Gun: From the Files of Police Squad!", "Cocktail", "Beetlejuice", "Three Men and a Baby", "Fatal Attraction", "Beverly Hills Cop II", "Good Morning", " Vietnam", "Moonstruck", "The Untouchables", "The Secret of My Success", "Stakeout", "Lethal Weapon", "The Witches of Eastwick", "Top Gun", "Crocodile Dundee", "Platoon", "The Karate Kid", " Part II", "Star Trek IV: The Voyage Home", "Back to School", "Aliens", "An American Tail", "The Golden Child", "Ruthless People", "Back to the Future", "Rambo: First Blood Part II", "Rocky IV", "The Color Purple", "Out Of Africa", "Cocoon", "The Jewel of the Nile", "Witness", "The Goonies", "Spies Like Us", "Ghostbusters", "Beverly Hills Cop", "Indiana Jones and the Temple of Doom", "Gremlins", "The Karate Kid", "Police Academy", "Footloose", "The Terminator", "Romancing the Stone", "Star Trek III: The Search for Spock", "Star Wars Episode VI: Return of the Jedi", "Terms of Endearment", "Flashdance", "Trading Places", "WarGames", "Octopussy", "Sudden Impact", "Staying Alive", "Mr. Mom", "Risky Business", "E.T. the Extra-Terrestrial", "Tootsie", "An Officer and a Gentleman", "Rocky III", "Porky's", "Star Trek II: The Wrath of Khan", "48 Hrs.", "Poltergeist", "The Best Little Whorehouse in Texas", "Annie", "Raiders of the Lost Ark", "On Golden Pond", "Superman II", "Arthur", "Stripes", "The Cannonball Run", "Chariots of Fire", "For Your Eyes Only", "The Four Seasons", "Time Bandits", "Star Wars Episode V: The Empire Strikes Back", "9 to 5", "Stir Crazy", "Airplane!", "Any Which Way You Can", "Private Benjamin", "Coal Miner's Daughter", "Smokey and the Bandit II", "The Blue Lagoon", "The Blues Brothers", "Kramer vs. Kramer", "The Amityville Horror", "Rocky II", "Apocalypse Now", "Star Trek: The Motion Picture", "Alien", "10", "The Jerk", "Moonraker", "The Muppet Movie", "Grease", "Superman", "National Lampoon's Animal House", "Every Which Way but Loose", "Heaven Can Wait", "Hooper", "Jaws 2", "Dawn of the Dead", "Revenge of the Pink Panther", "The Deer Hunter", "Star Wars", "Smokey and the Bandit", "Close Encounters of the Third Kind", "The Goodbye Girl", "Saturday Night Fever", "Oh", " God!", "A Bridge Too Far", "The Deep", "The Spy Who Loved Me", "Annie Hall", "Rocky", "To Fly!", "A Star Is Born", "All the President's Men", "The Omen", "In Search of Noah's Ark", "King Kong", "Silver Streak", "The Enforcer", "Midway", "Dog Day Afternoon", "Shampoo", "The Return of the Pink Panther", "Funny Lady", "The Apple Dumpling Gang", "Aloha", " Bobby and Rose", "The Other Side of the Mountain"));
    public List<Movie> toWatch=new ArrayList<>();
    public List<Movie> watched=new ArrayList<>();
    public ListView listview;
    final DatabaseHandler db = new DatabaseHandler(this);
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db.addSelected((ArrayList<String>) list);
        //deleteDatabase("KMovieLove");
        //db.close();


        tabLayoutMethod();
    }

    /*public void Movie_generator() {

        int index=db.getRandomId();
        String s= db.getList(index,"List");
        Toast.makeText(this, "The KMovie which chose you is " + s, Toast.LENGTH_SHORT).show();
        updateToWatch(index,s);
        SetAdapter();
    }

    private AlertDialog AskOption(final int pos)
    {
        AlertDialog myQuittingDialogBox = new AlertDialog.Builder(this)
                .setTitle("Watched")
                .setMessage("Have you watched this Movie?")


                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {
                        String delete= (String) listview.getItemAtPosition(pos);;
                        delete(delete);
                        dialog.dismiss();
                    }

                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();

                    }
                })
                .create();

        return myQuittingDialogBox;
    }

    public void SetAdapter() {
        toWatch = db.getAllMovie("ToWatch");
        List<String> toWatchList = new ArrayList<>();
        for (Movie Movie : toWatch) {
            toWatchList.add(Movie.getName());
        }
        listview = findViewById(R.id.sampleListView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                toWatchList);

        listview.setAdapter(arrayAdapter);

        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int pos, long id) {
                AlertDialog dialbox = AskOption(pos);
                dialbox.show();
                return true;
            }
        });
    }

    public void delete(String delete){
        int id=db.getId(delete);
        db.deleteMovie(id,"ToWatch");
        listview.invalidateViews();
        addToWatched(delete);
    }

    public void updateToWatch(int index,String s){
        db.deleteMovie(index,"List");
        db.addMovie(s,"ToWatch");
    }

    public void addToWatched(String delete){
        ArrayAdapter<String> adapter= (ArrayAdapter<String>) listview.getAdapter();
        listview.setAdapter(adapter);
        adapter.remove(delete);
        db.addMovie(delete,"Watched");
        watched=db.getAllMovie("Watched");
        List<String> WatchedList=new ArrayList<>();
        for(Movie Movie:watched){
            WatchedList.add(Movie.getName());
        }
    }*/

    public void tabLayoutMethod(){
        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);
        tabLayout.addTab(tabLayout.newTab().setText("To Watch"));
        tabLayout.addTab(tabLayout.newTab().setText("Watched"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final MyAdapter adapter = new MyAdapter(this,getSupportFragmentManager(),
                tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                startActivity(new Intent(MainActivity.this,ToWatch.class));
                startActivity(new Intent(MainActivity.this,Watched.class));
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }


        });
    }
}
