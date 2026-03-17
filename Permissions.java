// test comment

public interface Permissions 
{
    public boolean hasPermission(String user);
    public void    addPermission(String user);
    public void    removePermission(String user) throws InvalidPermission;
    public void    showPermissions();
}
