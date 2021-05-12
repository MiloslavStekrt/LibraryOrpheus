package dev.levia.LibraryOrpheus.own;

public class NavLink {
    private String location;
    private String show;
    public NavLink(String location, String show) {
        this.location = location;
        this.show = show;
    } 
    public String getLocation() { return location; }
    public String getShow() { return show; }
}
