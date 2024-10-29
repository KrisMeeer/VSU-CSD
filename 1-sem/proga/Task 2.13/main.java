import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите массу воды (в лит.): ");
        double m = sc.nextDouble();

        System.out.println("Введите начальную температуру воды: ");
        double t = sc.nextDouble();

        System.out.println("Введите переданную энергию: ");
        double k = sc.nextDouble();

        double c = 4200; // удельная теплоёмкость воды
        double l = 2260;  //удельная теплота парообразования воды кДж/кг
        double m_new = 0; // измененная масса
        double t_new = 0; // измененная температура
        double d_t = k / (m * c); // дельта т - разность тепературы
        temperature(d_t, t, m, m_new, t_new, k, c, l);

    }
        public static double temperature(double dT, double t, double m, double k, double c, double l){
            if (dT <= 100 - t) {
                m_new = m;
                t_new = t + dT;

                System.out.println("Вода нагрелась до температуры менее 100 градусов.");
                System.out.println("Остаточная масса воды: " + m_new + ". лит");
                System.out.println("Температура: " + t_new + "градусов Цельсия");


            } else {
                double v = (k - m * c * (100 - t)) / l;
                if (dT <= 100 - t + v) {
                    m_new = m - v;
                    t_new = 100;

                    System.out.println("Температура повысилась до 100 градусов, и часть воды испарилась.");
                    System.out.println("Остаточная масса воды: " + m_new + ". лит");
                    System.out.println("Температура: " + t_new + " градусов Цельсия");

                } else {
                    m_new = 0;

                    System.out.println("Вся вода испарилась.");
                    System.out.println("Остаточная масса воды: " + m_new + ". лит");
                }
            }
            return dT;
        }
    }
