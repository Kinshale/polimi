import numpy as np
import matplotlib.pyplot as plt

# Define the function H(s)
def H(s):
    return 1 + 0.01*s / (1 + 0.1 * s)

# Define the range of omega (imaginary part of s)
omega = np.linspace(-100, 100, 1000)  # range from -100 to 100
s = 1j * omega  # purely imaginary s

# Calculate H(s)
H_values = H(s)

# Extract magnitude and phase
magnitude = np.abs(H_values)
phase = np.angle(H_values)

# Plot magnitude and phase
plt.figure(figsize=(12, 6))

# Magnitude plot
plt.subplot(2, 1, 1)
plt.plot(omega, magnitude, label='|H(s)|', color='blue')
plt.title('Magnitude of H(s)')
plt.xlabel('Frequency (omega)')
plt.ylabel('|H(s)|')
plt.grid()
plt.legend()

# Phase plot
plt.subplot(2, 1, 2)
plt.plot(omega, phase, label='Phase of H(s)', color='orange')
plt.title('Phase of H(s)')
plt.xlabel('Frequency (omega)')
plt.ylabel('Phase (radians)')
plt.grid()
plt.legend()

plt.tight_layout()
plt.show()
