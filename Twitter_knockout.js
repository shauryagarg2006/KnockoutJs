function TweetModel(user_name,user_img,tweet_txt,tweet_img,tweet_count,tweet_like) {
    this.user_name = user_name;
    this.user_img = user_img;
    this.tweet_txt= tweet_txt;
    this.tweet_img=tweet_img;
    this.tweet_count= ko.observable(tweet_count+1);
    this.tweet_like= ko.observable(tweet_like+1);

    
};
function TwitterViewModel() {
    this.tweets = ko.observableArray([
        new TweetModel("@Elon Musk","images/elon.jpg","Feeling proud after landing SpaceX successfully.","images/spacex.jpg",21,11),
        new TweetModel("@Verge","images/verge.jpg","Happy two years of verge!","",5,21),
        new TweetModel("@NCState","images/NcState.jpg","Will Be Celebrating Golden Gubliee Soon :D","",500,221)
        ]);


    
};


ko.applyBindings(new TwitterViewModel());
