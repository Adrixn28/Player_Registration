public class Contacts {
    //Atributes
    private String LastName;
    private int numberSoccer;
    private String Sex;
    private String soccerTeam;

public Contacts(String LastName, int numberSoccer, String Sex, String soccerTeam){
    this.LastName = LastName;
    this.numberSoccer = numberSoccer;
    this.Sex = Sex;
    this.soccerTeam = soccerTeam;
}

public String GetLastName(){
    return LastName;
}

public void SetLastName(String LastName){
    this.LastName = LastName;
}

public int GetNumberSoccer(){
    return numberSoccer;
}

public void SetNumberSoccer(int numberSoccer){
    this.numberSoccer = numberSoccer;
}

public String GetSex(){
    return Sex;
}

public void SetSex(String Sex){
    this.Sex = Sex;
}

public String GetSoccerTeam(){
    return soccerTeam;
}

public void SetSoccerTeam(String soccerTeam){
    this.soccerTeam = soccerTeam;
}

@Override
public String toString(){
    return "Last name -> " + LastName + " | Number ("+numberSoccer+")" + "| Sex: " + Sex + "| Soccer Team: " + soccerTeam;
}
}
