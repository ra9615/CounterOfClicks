package nedra_test.entity;


import javax.persistence.*;

@Entity
@Table(name = "counter")
public class Click {

    @Id
    @Column(name = "counter_id")
    private int id;

    @Column(name = "sum_of_clicks")
    private int sum_of_clicks;

    public Click() {
    }

    public Click(int sum_of_clicks) {
        this.sum_of_clicks = sum_of_clicks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSum_of_clicks() {
        return sum_of_clicks;
    }

    public void setSum_of_clicks(int sum_of_clicks) {
        this.sum_of_clicks = sum_of_clicks;
    }

}
