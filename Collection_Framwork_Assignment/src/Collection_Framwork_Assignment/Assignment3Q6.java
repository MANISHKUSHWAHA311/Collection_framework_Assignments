package Collection_Framwork_Assignment;


import java.util.*;
import java.util.Map.Entry;

class Chatroom {
    private String name;
    private List<String> messages;
    private Set<String> users;

    public Chatroom(String name) {
        this.name = name;
        this.messages = new LinkedList<>();
        this.users = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void addMessage(String message) {
        messages.add(message);
    }

    public List<String> getMessages() {
        return messages;
    }

    public void addUser(String username) {
        users.add(username);
    }

    public Set<String> getUsers() {
        return users;
    }

    public void removeUser(String username) {
        users.remove(username);
    }

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	public void setUser(Set<String> users2) {
		this.users = users2;
	}
}
class User {
	
	private String username;
    private String password;
    private String firstName;
    private String lastName;
    
    public User() {
    	super();
    }
    public User(String username, String password, String firstName, String lastName) {
    	super();
    	this.username = username;
    	this.password = password;
    	this.firstName = firstName;
    	this.lastName = lastName;
    }
    
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + "]";
	}


}

class ChatApp {
//    private Map<String, Chatroom> chatrooms;
//    private Map<String, String> userToRoom;
//    private Map<String, String> passwordMap;

    private Map<String, Chatroom> chatrooms = new HashMap<String, Chatroom>();
    private Map<String, User> users = new HashMap<String, User>();
    private Set<String> loggedInUsers = new HashSet<String>();
    

//    { 
//    	User a=new User("Manish","8770","Manish","Kushwaha");
//    	
//    	User b=new User("jack","8770","jackk","kushwaha");
//    	users.put(a.getUsername(), a);
//    	users.put(b.getUsername(), a);
//    	loggedInUsers.add(a.getUsername());
//    	loggedInUsers.add(b.getUsername());
//    	Chatroom ch=new Chatroom("thunder");
//    	ch.addUser(a.getUsername());
//    	ch.addUser(b.getUsername());
//    	chatrooms.put(ch.getName(),ch);
//    	
//    	
//    }

    public boolean isChatroomNameValid(String name) {
    	
    	return name.matches("[a-zA-Z]+");
    }

    public boolean isUsernameExists(String username) {
    	return users.containsKey(username);
    }

    public boolean authenticateUser(String username, String password) {
    		
    	return users.get(username).getPassword().equalsIgnoreCase(password);
    	
    }

    public void createChatroom(String name) {
        Chatroom chatroom = new Chatroom(name);
        chatrooms.put(name, chatroom);
        System.out.println("Chatroom created successfully");
    }

    public void addUser(String chatroomName,User user) {
        if (isUsernameExists(user.getUsername())) {
            System.out.println("User already exists");
            return;
        }
        users.put(user.getUsername(), user);
        Chatroom chatroom = chatrooms.get(chatroomName);
        if(chatroom!=null)
        {
        	chatroom.addUser(user.getUsername());
        }
        else
        {   
            Chatroom newchatroom=new Chatroom(chatroomName);
            newchatroom.addUser(user.getUsername());
        }
        System.out.println("User added successfully");
    }

    public void login(String username, String password) {
		    if (!isUsernameExists(username)) {
		        System.out.println("User not found");
		        return;
		    }
		    if(authenticateUser(username,password))
		    {		    	
		    	System.out.println("Login successful");
		    	loggedInUsers.add(username);
		    	return;
		    }
		    System.out.println("Incorrect Password");
    }
    
	  public void listUsersFromChatroom(String roomName) {
		  
		  if (!chatrooms.containsKey(roomName)) {
		      System.out.println("Chatroom not found");
		      return;
		  }
		  Chatroom chatroom = chatrooms.get(roomName);
		  Set<String> users = chatroom.getUsers();
		  if (users.isEmpty()) {
		      System.out.println("No users found");
		      return;
		  }
		  for (String user : users) {
		      System.out.println(user);
		  }
	 }
	  
	public void logout(String username) {
	  if (!loggedInUsers.contains(username)) {
	      System.out.println("User not logged in");
	      return;
	  }
	  loggedInUsers.remove(username);
	  System.out.println("Logout successful");
	}
	
	public void sendMessage(String username, String message) {
	
			if (!loggedInUsers.contains(username)) {
			      System.out.println("User not logged in");
			      return;
			  }
	
	    String chatroom_name="";
	    for ( Map.Entry<String, Chatroom> entry : chatrooms.entrySet()) {
	        String key = entry.getKey();
	        Chatroom value = entry.getValue();
	        System.out.println(value.getUsers());
	        for(String str:value.getMessages())
	        {	
	        	System.out.println(str);
	        }
	        for(String str:value.getUsers())
	        {	
	        	if(str.equals(username))
	        	{
	        		chatroom_name+=key;
	        		break;
	        	}
	        }
	        
	    }
	    
	    System.out.println(chatroom_name);
	    
	    Chatroom updatedChatroom=new Chatroom(chatroom_name);
	    List<String> allmessages=chatrooms.get(chatroom_name).getMessages();
	    allmessages.add(username + ": " + message);
	    updatedChatroom.setMessages(allmessages);
	    
	    Set<String> users2 = chatrooms.get(chatroom_name).getUsers();
	    users2.add(username);
	    updatedChatroom.setUser(users2);
	    System.out.println(updatedChatroom.getMessages());
	    
	    chatrooms.put(chatroom_name,updatedChatroom);
	    System.out.println("Message sent successfully");

	  }
		    
	   public void printMessages(String roomName) {
		  if (!chatrooms.containsKey(roomName)) {
		      System.out.println("Chatroom not found");
		      return;
		  }
		  Chatroom chatroom = chatrooms.get(roomName);
		  List<String> messages = chatroom.getMessages();
		  if (messages.isEmpty()) {
		      System.out.println("No messages found");
		      return;
		  }
		  for (String message : messages) {
		      System.out.println(message);
		  }
	   }
	   
	   public void deleteUser(String username){
		
		   users.remove(username);
		   System.out.println("User deleted");
		    
	   }

	public void deleteChatroom(String chatroomname_2) {
		
		chatrooms.remove(chatroomname_2);
		System.out.println("Chatroom deleted");

	}
}


public class Assignment3Q6{
	
    public static void main(String[] args){
    	
    	Scanner sc=new Scanner(System.in);
       	
    	ChatApp chat=new ChatApp();
    	int session=0;
    	do
    	{
    		System.out.println("A. Create a chatroom\n"+"B. Add the user\n"+"C. User login\n"
    				+"D. Send a message\n"+"E. Display the messages from a specific chatroom\n"+"F. List down all users belonging to the specified chat room.\n"
    				+"G. Logout\n"+"H. Delete an user\n"+"I. Delete the chat room.\n");
    		System.out.println("Please enter your option:");
    		String option=sc.nextLine().toUpperCase();
    		switch(option)
        	{
        	  case "A":
    	    		String roomname=sc.nextLine();
    	    		chat.createChatroom(roomname);
    	    		System.out.println(roomname);
    	    		break;
        		  
        	  case "B":
        		    System.out.println("Username :");
        			String username=sc.nextLine();
        			System.out.println("Password :");
        			String password=sc.nextLine();
        			System.out.println("Firstname :");
        			String firstname=sc.nextLine();
        			System.out.println("Lastname :");
        			String lastname=sc.nextLine();
        		    User newuser=new User(username,password,firstname,lastname);
        		    System.out.println("ChatroomName :");
        			String chatroomName=sc.nextLine();
        		    chat.addUser(chatroomName,newuser);
        		    break;
        		  
        	  case "C":
        		    System.out.println("Username :");
    	  			String loginUsername=sc.nextLine();
    	  			System.out.println("Password :");
    	  			String loginPassword=sc.nextLine();
    	  			chat.login(loginUsername, loginPassword);
    	  			break;
    	  			
        	  case "D":
	        		System.out.println("Username :");
	  	  			String usernamep=sc.nextLine();
	  	  			System.out.println("Message :");
	  	  			String message=sc.nextLine();
	        		chat.sendMessage(usernamep,message);
	        		break;
        		  
        	  case "E":
        		    System.out.println("ChatroomName :");
	      			String chatroomname_0=sc.nextLine();
        		    chat.printMessages(chatroomname_0);
        		    break;
        	  case "F":
	        		System.out.println("ChatroomName :");
	      			String chatroomname_1=sc.nextLine();
	        		chat.listUsersFromChatroom(chatroomname_1);
	        		break;
        	  case "G":
        		    System.out.println("Username :");
  	  			    String usernamea=sc.nextLine();
        		    chat.logout(usernamea);
        		    break;
        	  case "H":
        		    System.out.println("Username :");
	  			    String usernameb=sc.nextLine();
        		    chat.deleteUser(usernameb);
        		    break;
        	  case "I":
        			System.out.println("ChatroomName :");
	      			String chatroomname_2=sc.nextLine();
	      			chat.deleteChatroom(chatroomname_2);
        		    
        	}
        	
    	}while(session==0);
    	
    	
    }
}



