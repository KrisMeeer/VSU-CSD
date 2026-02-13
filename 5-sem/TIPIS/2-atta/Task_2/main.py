import numpy as np
import matplotlib.pyplot as plt
from scipy.fft import fft, ifft, fftfreq
from scipy.signal import butter, filtfilt

# Параметры сигнала
Fs = 1000 # Частота дискретизации
T = 1 / Fs # Период дискретизации
L = 1500 # Количество отсчетов
t = np.arange(L) * T # Временная ось

# Параметры несущей и модуляции
A = 1 # Амплитуда несущей
fc = 50 # Частота несущей
fm = 5 # Частота модуляции (меандра)
m = 0.8 # Глубина/индекс модуляции

# 1. Создание исходных сигналов
harmonic = A * np.sin(2 * np.pi * fc * t)
meandr = 0.5 * (np.sign(np.sin(2 * np.pi * fm * t)) + 1)

# 2. Создание модулированных сигналов
am_signal = (1 + m * meandr) * harmonic
fm_signal = np.sin(2 * np.pi * (fc + 20 * m * meandr) * t)
pm_signal = np.sin(2 * np.pi * fc * t + np.pi * m * meandr)

# 3. Вычисление спектров
freqs = fftfreq(L, T)
am_spectrum = fft(am_signal)
fm_spectrum = fft(fm_signal)
pm_spectrum = fft(pm_signal)

am_amplitude = np.abs(am_spectrum) / L
fm_amplitude = np.abs(fm_spectrum) / L
pm_amplitude = np.abs(pm_spectrum) / L

# 4. Фильтрация спектра AM сигнала для синтеза
am_spectrum_filtered = am_spectrum.copy()
center_freq = fc
bandwidth = 40 # Полоса для захвата гармоник меандра

idx_low = max(0, int((center_freq - bandwidth/2) * L / Fs))
idx_high = min(L//2, int((center_freq + bandwidth/2) * L / Fs))

am_spectrum_filtered[:idx_low] = 0
am_spectrum_filtered[idx_high:-idx_high] = 0
am_spectrum_filtered[-idx_low:] = 0

# 5. Синтез сигнала
am_synthesized = np.real(ifft(am_spectrum_filtered))

# 6. Извлечение сигнала (Демодуляция) по требованию преподавателя
def extract_signal(signal, fs, cutoff):
    # Детектирование (амплитудное выпрямление)
    rectified = np.abs(signal)
    # ФНЧ для удаления несущей
    nyquist = 0.5 * fs
    b, a = butter(4, cutoff / nyquist, btype='low')
    envelope = filtfilt(b, a, rectified)
    # Центрирование и нормализация
    extracted = envelope - np.mean(envelope)
    extracted = (extracted - np.min(extracted)) / (np.max(extracted) - np.min(extracted))
    return extracted

extracted_meandr = extract_signal(am_synthesized, Fs, cutoff=fm*2.5)

threshold_value = 0.5
final_digital_signal = (extracted_meandr > threshold_value).astype(float)

# Параметры отображения (3 периода)
period_fm = 1 / fm
samples_3_periods = int(3 * period_fm * Fs)

# --- ПЕРВОЕ ОКНО: ОБЩИЕ ГРАФИКИ ---
plt.figure(figsize=(16, 12))

plt.subplot(4, 4, 1)
plt.plot(t[:samples_3_periods], harmonic[:samples_3_periods])
plt.title('Исходный гармонический сигнал (3 периода)')
plt.xlabel('Время (с)')
plt.ylabel('Амплитуда')
plt.grid(True)
plt.axvline(x=period_fm, color='r', linestyle='--', alpha=0.5)
plt.axvline(x=2*period_fm, color='r', linestyle='--', alpha=0.5)

plt.subplot(4, 4, 2)
plt.plot(t[:samples_3_periods], meandr[:samples_3_periods])
plt.title(f'Модулирующий сигнал (меандр, {fm} Гц)')
plt.xlabel('Время (с)')
plt.ylabel('Амплитуда')
plt.grid(True)
plt.axvline(x=period_fm, color='r', linestyle='--', alpha=0.5)
plt.axvline(x=2*period_fm, color='r', linestyle='--', alpha=0.5)

plt.subplot(4, 4, 5)
plt.plot(t[:samples_3_periods], am_signal[:samples_3_periods])
plt.title('Амплитудно-модулированный сигнал (AM)')
plt.xlabel('Время (с)')
plt.ylabel('Амплитуда')
plt.grid(True)
plt.axvline(x=period_fm, color='r', linestyle='--', alpha=0.5)
plt.axvline(x=2*period_fm, color='r', linestyle='--', alpha=0.5)

plt.subplot(4, 4, 6)
plt.plot(t[:samples_3_periods], fm_signal[:samples_3_periods])
plt.title('Частотно-модулированный сигнал (FM)')
plt.xlabel('Время (с)')
plt.ylabel('Амплитуда')
plt.grid(True)
plt.axvline(x=period_fm, color='r', linestyle='--', alpha=0.5)
plt.axvline(x=2*period_fm, color='r', linestyle='--', alpha=0.5)

plt.subplot(4, 4, 7)
plt.plot(t[:samples_3_periods], pm_signal[:samples_3_periods])
plt.title('Фазомодулированный сигнал (PM)')
plt.xlabel('Время (с)')
plt.ylabel('Амплитуда')
plt.grid(True)
plt.axvline(x=period_fm, color='r', linestyle='--', alpha=0.5)
plt.axvline(x=2*period_fm, color='r', linestyle='--', alpha=0.5)

freq_pos = freqs[:L//2]

plt.subplot(4, 4, 9)
plt.plot(freq_pos, am_amplitude[:L//2])
plt.title('Спектр AM сигнала')
plt.xlabel('Частота (Гц)')
plt.ylabel('Амплитуда')
plt.xlim([0, 150])
plt.grid(True)

plt.subplot(4, 4, 10)
plt.plot(freq_pos, fm_amplitude[:L//2])
plt.title('Спектр FM сигнала')
plt.xlabel('Частота (Гц)')
plt.ylabel('Амплитуда')
plt.xlim([0, 150])
plt.grid(True)

plt.subplot(4, 4, 11)
plt.plot(freq_pos, pm_amplitude[:L//2])
plt.title('Спектр PM сигнала')
plt.xlabel('Частота (Гц)')
plt.ylabel('Амплитуда')
plt.xlim([0, 150])
plt.grid(True)

am_amplitude_filtered = np.abs(am_spectrum_filtered) / L
plt.subplot(4, 4, 13)
plt.plot(freq_pos, am_amplitude_filtered[:L//2])
plt.title('Отфильтрованный спектр AM (для синтеза)')
plt.xlabel('Частота (Гц)')
plt.ylabel('Амплитуда')
plt.xlim([0, 100])
plt.grid(True)
plt.axvline(x=center_freq - bandwidth/4, color='r', linestyle='--', alpha=0.5)
plt.axvline(x=center_freq + bandwidth/4, color='r', linestyle='--', alpha=0.5)
plt.fill_betweenx([0, np.max(am_amplitude_filtered[:L//2])],
                  center_freq - bandwidth/4, center_freq + bandwidth/4,
                  alpha=0.3, color='yellow')

plt.subplot(4, 4, 14)
plt.plot(t[:samples_3_periods], am_synthesized[:samples_3_periods])
plt.title('Синтезированный AM сигнал (3 периода)')
plt.xlabel('Время (с)')
plt.ylabel('Амплитуда')
plt.grid(True)
plt.axvline(x=period_fm, color='r', linestyle='--', alpha=0.5)
plt.axvline(x=2*period_fm, color='r', linestyle='--', alpha=0.5)

plt.tight_layout()
plt.show()

# --- Второе ОКНО:

plt.figure(figsize=(12, 9))
# График 1: Извлеченный сигнал vs Исходный меандр
plt.subplot(2, 1, 1)
plt.plot(t[:samples_3_periods], extracted_meandr[:samples_3_periods], 'b', linewidth=2, label='Извлеченный меандр')
plt.plot(t[:samples_3_periods], meandr[:samples_3_periods], 'r--', alpha=0.7, label='Исходный меандр')
plt.title('Результат извлечения сигнала из синтезированной AM-огибающей')
plt.legend()
plt.grid(True)

# График 2: ОБЪЕДИНЕННЫЙ ФИНАЛЬНЫЙ ГРАФИК
plt.subplot(2, 1, 2)
# 1. Исходный меандр (пунктиром)
plt.plot(t[:samples_3_periods], meandr[:samples_3_periods], 'r:', alpha=0.5, label='Исходный меандр')
# 2. Восстановленная огибающая (полупрозрачная)
plt.plot(t[:samples_3_periods], extracted_meandr[:samples_3_periods], 'b', alpha=0.3, label='Восстановленная огибающая')
# 3. Линия порога
plt.axhline(y=threshold_value, color='green', linewidth=1, label='Порог')
# 4. Финальный цифровой сигнал (ступенчатый)
plt.step(t[:samples_3_periods], final_digital_signal[:samples_3_periods], 'grey', linewidth=1, where='post', label='Финальный цифровой сигнал')

plt.title('Восстановление цифрового сигналал')
plt.xlabel('Время (с)')
plt.ylabel('Уровень')
plt.legend(loc='upper right')
plt.grid(True)

plt.tight_layout()
plt.show()