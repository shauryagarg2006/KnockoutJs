function TweetModel(user_name,user_img,tweet_txt,tweet_img,tweet_count,tweet_like) {
    this.user_name = user_name;
    this.user_img = user_img;
    this.tweet_txt= tweet_txt;
    this.tweet_img=tweet_img;
    this.tweet_count= ko.observable(tweet_count);
    this.tweet_like= ko.observable(tweet_like);

    
}
function TwitterViewModel() {
 var self = this;
 self.tweets = ko.observableArray([
    new TweetModel("@Elon Musk","images/elon.jpg","Feeling proud after landing SpaceX successfully.","images/spacex.jpg",21,11),
    new TweetModel("@Verge","images/verge.jpg","Happy two years of verge!","",5,21),
    new TweetModel("@Sgarg7","images/sgarg7.jpg","Excited about the new phone by Google - Pixel","images/pixel.png",19,9),
    new TweetModel("@NCState","images/NcState.jpg","Will Be Celebrating Golden Gubliee Soon :D","",500,221)
    ]);

 self.retweetFunc= function(sel_tweet){
        //alert("hi");
        sel_tweet.tweet_count(sel_tweet.tweet_count()+1);
    };
    self.likeFunc= function(sel_tweet){
        //alert("hi");
        sel_tweet.tweet_like(sel_tweet.tweet_like()+1);
    };
    self.removeFunc = function(sel_tweet) { self.tweets.remove(sel_tweet);}
    self.addFunc = function(sel_tweet) { 
        self.tweets.unshift(new TweetModel(sel_tweet.user_name,sel_tweet.user_img,sel_tweet.tweet_txt,sel_tweet.tweet_img,0,0));
    }
    self.tweet_new=ko.observable();
    self.onSubmit = function() {
        self.tweets.unshift( new TweetModel("@sgarg7","images/sgarg7.jpg",self.tweet_new(),"",0,0));
        self.tweet_new("");}
    }


    ko.applyBindings(new TwitterViewModel());
