package dev.levia.LibraryOrpheus.own;

public class OperationMethods {

    public static NavLink[] navigation(int role) {
        if (role == 1) {
            return new NavLink[] {
                new NavLink("/person", "Persons"),
                new NavLink("/school", "School"),
                new NavLink("/event", "Events"),
                new NavLink("/pet", "Pets")
            };
        }
        return new NavLink[] {
            new NavLink("/log", "Login"),
            new NavLink("reg", "Register")
        };
    }
    
}
