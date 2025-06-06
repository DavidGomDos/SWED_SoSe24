package Exercise_6;


class User implements Observer {
    private String name;
    private String email;
    private String channel;

    public User(String name, String email, String channel) {
        this.name = name;
        this.email = email;
        this.channel = channel;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getChannel() {
        return channel;
    }

    // Observer method
    @Override
    public void update(String message) {
        sendNotification(message);
    }

    public void sendNotification(String msg) {
        System.out.println("\n");
        if ("email".equals(channel)) {
            System.out.printf("e-mail to " + email + ": " + msg);
        } else {
            System.out.printf("sms to " + name + ": " + msg);
        }
    }
}
