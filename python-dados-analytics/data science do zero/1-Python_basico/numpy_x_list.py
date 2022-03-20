# -*- coding: utf-8 -*-
"""numpy_x_list.ipynb

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/12EAQalEA-BKQGXnc8z9aUS-9ynrJCvIQ
"""

import numpy as np
import timeit

l = range(100)
a = np.arange(100)

# Commented out IPython magic to ensure Python compatibility.
# %timeit Y = [ l[i] * 4 for i in range(len(l)) ]
# %timeit W = [x for x in range(5) if x % 2 == 0] 
# %timeit Z = a * 4

Y = [ l[i] * 4 for i in range(len(l)) ]
# W = [x for x in range(5) if x % 2 == 0] 
Z = a * 4

for i in range(len(Z)):
  print(Z[i])