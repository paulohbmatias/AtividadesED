class LDE {
        private var inicio:No?
        private var fim:No?
        private var tamanho:Int
        init {
            fim = null
            inicio = null
            tamanho = 0
        }
        fun tamanho() = tamanho

        fun vazia():Boolean = tamanho == 0

        fun elemento(pos:Int):Int{
            var aux:No? = inicio
            if(vazia() || pos<1 || pos>tamanho) return -1
            for(i in 1..(pos-1)) aux = aux?.proximo
            return aux!!.conteudo
        }
        fun posicao(dado:Int):Int{
            var cont:Int = 1
            var aux:No?
            if(vazia()) return 0
            aux = inicio
            while (aux != null){
                if(aux.conteudo == dado) return cont
                aux = aux.proximo
                cont++
            }
            return -1
        }
        private fun insereInicioLista(valor:Int):Boolean{
            val novoNo:No = No(valor)
            novoNo.proximo = inicio

            novoNo.ant = null
            if(vazia()) fim = novoNo else inicio?.ant = novoNo

            inicio = novoNo
            tamanho++
            return true
        }
        private fun insereMeioLista(pos:Int, valor:Int):Boolean{
            var cont = 1
            val novoNo = No(valor)
            var aux = inicio
            while ((cont<pos-1)&&(aux!=null)){
                aux = aux.proximo
                cont++
            }
            if(aux == null) return false

            novoNo.ant = aux
            novoNo.proximo = aux.proximo

            aux.proximo?.ant = novoNo
            aux.proximo = novoNo
            tamanho++
            return true
        }
        private fun insereFimLista(valor:Int):Boolean{
            val novoNo = No(valor)
            var aux = inicio
            while (aux?.proximo != null) aux = aux.proximo
            novoNo.proximo = null
            aux?.proximo = novoNo

            novoNo.ant = fim
            fim?.proximo = novoNo
            fim = novoNo

            tamanho++
            return true
        }

        private fun removeInicioLista(): Int? {
            var p = inicio
            val dado = p?.conteudo
            inicio = p?.proximo
            p?.proximo?.ant = null
            tamanho--
            p = null

            return dado

        }
        private fun removeInicioListaUnitaria(): Int? {
            val dado:Int = inicio!!.conteudo
            inicio = null
            fim = null
            tamanho--
            return dado
        }


        private fun removeMeioLista(pos:Int):Int{
            var p = inicio
            var n = 1

            while ((n<=pos-1) && (p!=null)){
                p = p.proximo
                n++
            }

            if(p==null) return -1
            var dado = p.conteudo
            p.ant?.proximo = p.proximo
            p.proximo?.ant = p.ant
            tamanho--
            p = null
            return dado



        }

        private fun removeFimLista(): Int? {
            var p = fim
            val dado = p?.conteudo

            fim?.ant?.proximo = null
            fim = fim?.ant
            tamanho--

            p = null
            return dado
        }

        fun remove(pos:Int): Int? {
            if(vazia()) return 0
            if((pos==1) && tamanho == 1 ) return removeInicioListaUnitaria()
            else if(pos == 1) return removeInicioLista()
            else if(pos == tamanho) return removeFimLista()
            else return removeMeioLista(pos)
        }

        fun insere(pos:Int, valor:Int):Boolean{
            if(vazia() && pos != 1) return false
            when (pos) {
                1 -> return insereInicioLista(valor)
                tamanho+1 -> return insereFimLista(valor)
                else -> return insereMeioLista(pos, valor)
            }
        }


}