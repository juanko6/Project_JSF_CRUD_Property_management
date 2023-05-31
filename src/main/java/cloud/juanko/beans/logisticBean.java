package cloud.juanko.beans;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

@ManagedBean
public class logisticBean {
    private LineChartModel lineModel;
    private double r;
    private double k;
    private double x0;

    @PostConstruct
    public void init() {
        createLineModel();
    }

    public LineChartModel getLineModel() {
        return lineModel;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getK() {
        return k;
    }

    public void setK(double k) {
        this.k = k;
    }

    public double getX0() {
        return x0;
    }

    public void setX0(double x0) {
        this.x0 = x0;
    }

    public void generarGrafica() {
        createLineModel();
    }

    private void createLineModel() {
        lineModel = new LineChartModel();
        LineChartSeries series = new LineChartSeries();
        series.setLabel("Población");

        double x = x0;
        series.set(0, x0);

        for (int i = 1; i <= 10; i++) {
            x = r * x * (1 - x / k);
            series.set(i, x);
        }

        lineModel.addSeries(series);
    }
}
