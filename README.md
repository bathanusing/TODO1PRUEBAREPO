## Añadir data
#Usar los archivos con el nombre SampleUserData o SampleProductData si se quiere añadir mas data
TODO:
En la misma ruta en la que se encuentra el archivo abrir un bash y usar este comando

bcp USERMVDC in SampleUserData -S todo1mvdc.database.windows.net -d todo1MvDc -U adminjuan -P admin123. -q -c -t ","

bcp PRODUCTMVDC in SampleProductData -S todo1mvdc.database.windows.net -d todo1MvDc -U adminjuan -P admin123. -q -c -t ","