public enum Gender {
    MALE("Male"),
    FEMALE("Female"),
    UNDEFINED("Undefined");

    private String title;
    public String getTitle (){
        return title;
    }
    Gender(String title){
this.title=title;
    }
}
