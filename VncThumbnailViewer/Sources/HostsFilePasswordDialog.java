import java.awt.*;
  private TextField passField;
  private String password;
  
  public HostsFilePasswordDialog(Frame parent, boolean isSaving) {
    super(parent);
    
    result = false;
    password = null;

    GridBagLayout gridbag = new GridBagLayout();
    GridBagConstraints c = new GridBagConstraints();
    setLayout(gridbag);
    setModal(true);
    setResizable(false);
    Point loc = parent.getLocation();
    Dimension dim = parent.getSize();
    loc.x += (dim.width/2)-50;
    loc.y += (dim.height/2)-50;
    setLocation(loc);
    
    // Password:
    Label p = new Label("Password:", Label.CENTER);
    p.setFont(new Font(null, Font.BOLD, 24));
    c.gridwidth = GridBagConstraints.REMAINDER;
    gridbag.setConstraints(p, c);
    add(p);
    // To protect login info...
    if(isSaving) {
      Label e = new Label("To protect login information\n enter a password to encrypt\n this file with.  (To leave file\n unencrypted, click NONE)", Label.CENTER);
      c.gridwidth = GridBagConstraints.REMAINDER;
      gridbag.setConstraints(e, c);
      add(e);
    }
    // [__________________]
    passField = new TextField(20);
    passField.setEchoChar('*');
    c.gridwidth = GridBagConstraints.REMAINDER;
    gridbag.setConstraints(passField, c);
    add(passField);
    // ( None )
    if(isSaving) {
      cancel = new Button("None");
      cancel.addActionListener(this);
      c.gridwidth = 1;
      gridbag.setConstraints(cancel, c);
      add(cancel);
    }
    // ( OK )
    ok = new Button("OK");
    ok.addActionListener(this);
    c.gridwidth = GridBagConstraints.REMAINDER;
    gridbag.setConstraints(ok, c);
    add(ok);

    pack();
  
  public boolean getResult() {
    return result;
  }
  
  public String getPassword() {
    return password;
  }
      result = true;
    } else {
      result = false;
    }
    password = passField.getText();