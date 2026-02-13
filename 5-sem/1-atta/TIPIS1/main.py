import matplotlib.pyplot as plt
import numpy as np

frequencies = [1, 2, 4, 8]


def generate_signal(freq, move, signal_type):
    x_values = np.arange(0, 2, move)
    if signal_type == "harmonic":
        y_values = np.cos(2 * np.pi * freq * x_values)
    elif signal_type == "digital":
        y_values = np.where(np.cos(2 * np.pi * freq * x_values) >= 0, 1, 0)
    return [x_values, y_values]


def calculate_spectrum(y_values, move):
    y_values = y_values - np.mean(y_values)
    fft_values = np.fft.rfft(y_values)
    x_values = np.fft.rfftfreq(len(y_values), d=move)
    return [x_values, np.abs(fft_values)]


def compose_signals(move, signal_type):
    signals = []
    for freq in frequencies:
        x_values, y_values = generate_signal(freq, move, signal_type)
        signals.append([x_values, y_values])
    return signals


def compose_spectrum(charts, move):
    spectrum = []
    for chart in charts:
        x_values, y_values = calculate_spectrum(chart[1], move)
        spectrum.append([x_values, y_values])
    return spectrum


def plot(charts, name, plot_type):
    num_charts = len(charts)
    num_cols = min(num_charts, 4)
    num_rows = (num_charts + num_cols - 1) // num_cols

    fig, axs = plt.subplots(num_rows, num_cols, figsize=(15, 10))
    fig.suptitle(name.format(""))

    for i, data in enumerate(charts):
        row = i // num_cols
        col = i % num_cols
        axs[row, col].plot(data[0], data[1])
        if i < num_charts // 2:
            axs[row, col].set_title("Частота: {} Гц (Гармонический)".format(frequencies[i]))
        else:
            axs[row, col].set_title("Частота: {} Гц (Цифровой)".format(frequencies[i - num_charts // 2]))
        if plot_type == "signal":
            axs[row, col].set_xlabel("Время")
            axs[row, col].set_ylabel("Амплитуда")
        elif plot_type == "spectrum":
            axs[row, col].set_xlabel("Частота")
            axs[row, col].set_ylabel("Амплитуда")
            for ax in axs.flat:
                ax.set_xlim([0, 30])

    plt.tight_layout()
    plt.savefig(name.format("") + ".png")
    plt.show()


def program():
    move_h = 0.0001
    move_d = 0.0001

    harmonic_signals = compose_signals(move_h, "harmonic")
    digital_signals = compose_signals(move_d, "digital")

    spectrum_harmonic_signals = compose_spectrum(compose_signals(move_h, "harmonic"), move_h)
    spectrum_digital_signals = compose_spectrum(compose_signals(move_d, "digital"), move_d)

    plot(harmonic_signals + digital_signals, "Сигналы", "harmonic")
    plot(spectrum_harmonic_signals + spectrum_digital_signals, "Спектры", "spectrum")


program()
