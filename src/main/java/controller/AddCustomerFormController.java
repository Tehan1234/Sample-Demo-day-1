package controller;

import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import model.Customer;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class AddCustomerFormController implements Initializable {

    @FXML
    private ComboBox<String> cmbTitle;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtId;

    @FXML
    private JFXTextField txtName;

    @FXML
    private DatePicker txtdob;

    @FXML
    void btnAddOnAction(ActionEvent event) {
        String id = txtId.getText().trim();
        String name = txtName.getText().trim();
        String address = txtAddress.getText().trim();
        LocalDate dob = txtdob.getValue();
        String title = cmbTitle.getValue();

        Customer customer = new Customer(id, name, address, dob, title);
        System.out.println(customer);

        List<Customer> customerList = DBConnection.getInstance().getConnection();
        customerList.add(customer);




    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> titles = FXCollections.observableArrayList();
        titles.add("Mrs");
        titles.add("Miss");
        cmbTitle.setItems(titles);


    }
}
