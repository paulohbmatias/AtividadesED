class ArvBin {
    private var raiz:NoTree? = null

    //verifica se a arvore ta vazia
    fun vazia() = raiz == null
    fun busca(t:NoTree?, valor:Int):NoTree?{
        if(t == null) return null
        if(t.conteudo == valor) return t
        var aux:NoTree? = busca(t.esq, valor)
        if(aux == null) aux = busca(t.dir, valor)
        return aux
    }
    fun busca(valor:Int) = if(vazia()) null else busca(raiz, valor)
    fun insereRaiz(valor: Int):Boolean{
        if(raiz != null) return false
        val novoNo = NoTree(valor)
        novoNo.esq = null
        novoNo.dir = null
        raiz = novoNo
        return true
    }
    fun insereDir(vPai:Int, vFilho:Int):Boolean{
        val filho = busca(vFilho)
        if(filho != null) return false

        val pai = busca(vPai)
        if(pai == null) return false
        if(pai.dir != null) return false

        val novoNo = NoTree(vFilho)
        novoNo.esq = null
        novoNo.dir = null

        pai.dir = novoNo

        return true
    }

    fun insereEsq(vPai:Int, vFilho:Int):Boolean{
        val filho = busca(vFilho)
        if(filho != null) return false

        val pai = busca(vPai)
        if(pai == null) return false
        if(pai.esq != null) return false

        val novoNo = NoTree(vFilho)
        novoNo.esq = null
        novoNo.dir = null

        pai.esq = novoNo

        return true
    }

    fun exibePreOrdem(t:NoTree?){
        if(t==null) return
        print(" "+t.conteudo)
        if(t.esq != null) exibePreOrdem(t.esq)
        if(t.dir != null) exibePreOrdem(t.dir)
    }
    fun exibePreOrdem() = if(raiz == null) println("Arvore vazia") else exibePreOrdem(raiz)
    fun exibeInOrdem(t:NoTree?){
        if(t==null) return
        if(t.esq != null) exibeInOrdem(t.esq)
        print(" "+t.conteudo)
        if(t.dir != null) exibeInOrdem(t.dir)
    }
    fun exibeInOrdem() = if(raiz == null) println("Arvore vazia") else exibeInOrdem(raiz)
    fun exibePosOrdem(t:NoTree?){
        if(t==null) return

        if(t.esq != null) exibePosOrdem(t.esq)
        if(t.dir != null) exibePosOrdem(t.dir)
        print(" "+t.conteudo)
    }
    fun exibePosOrdem() = if(raiz == null) println("Arvore vazia") else exibePosOrdem(raiz)

}