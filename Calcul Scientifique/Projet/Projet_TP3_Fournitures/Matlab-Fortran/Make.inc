FC    = gfortran -g -fcheck=bounds,array-temps -fbacktrace

# Machines salle TP
LIBS   = /mnt/n7fs/ens/tp_abuttari/acml-4.4.0/gfortran64/lib/libacml.a -lm
PLIBS  = /mnt/n7fs/ens/tp_abuttari/acml-4.4.0/gfortran64_mp/lib/libacml_mp.a

%.o: %.f90
	$(FC) -c $<  

%.o: %.F90
	$(FC) -c $<  

%.o: %.f
	$(FC) -c $<  

