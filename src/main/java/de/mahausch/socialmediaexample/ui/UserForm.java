package de.mahausch.socialmediaexample.ui;

import com.vaadin.data.Binder;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;
import de.mahausch.socialmediaexample.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;


@SpringComponent @UIScope public class UserForm extends FormLayout {

    private TextField name = new TextField("Name");
    private DateField birthdate = new DateField("Birth Date");
    private Button save = new Button("Save");
    private Button delete = new Button("Delete");

    private User user;

    @Autowired @Lazy private VaadinUI ui;

    private Binder<User> binder = new Binder<>(User.class);

    public UserForm() {
        setSizeUndefined();
        HorizontalLayout buttons = new HorizontalLayout(save, delete);
        addComponents(name, birthdate, buttons);

        save.setStyleName(ValoTheme.BUTTON_PRIMARY);
        save.setClickShortcut(KeyCode.ENTER);

        binder.bindInstanceFields(this);

        save.addClickListener(e -> this.save());
        delete.addClickListener(e -> this.delete());
    }

    public void setUser(User user) {
        this.user = user;
        binder.setBean(user);

        // Show delete button for only customers already in the database
        delete.setVisible(user.isPersisted());
        setVisible(true);
        name.selectAll();
    }

    public User getUser() {
        return user;
    }

    private void delete() {
        ui.delete(user);
        ui.updateList();
        setVisible(false);
    }

    private void save() {
        ui.save(user);
        ui.updateList();
        setVisible(false);
    }

}