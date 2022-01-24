package object;

public class Room {
	private String name;
	private int	no;
	private String passward;
	
	public Room() {
    }
    public void setName(Room[] ro, String name, int index) {
    	ro[index].name = name;
    }
    public String getName(Room[] ro, int index) {
    	return ro[index].name;
    }
    public void setNo(Room[] ro, int no, int index) {
    	ro[index].no = no;
    }
    public int getNo(Room[] ro, int index) {
    	return ro[index].no;
    }
    public void setPassward(Room[] ro, String passward, int index) {
    	ro[index].passward = passward;
    }
    public String getPassward(Room[] ro, int index) {
    	return ro[index].passward;
    }
}
