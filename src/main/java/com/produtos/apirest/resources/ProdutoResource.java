package com.produtos.apirest.resources;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Produtos")
@CrossOrigin(origins="*")
public class ProdutoResource {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("/produtos")
    @ApiOperation(value="Retorna uma lista de produtos.")
    public List<Produto> listaProdutos() {
        return produtoRepository.findAll();
    }

    @GetMapping("/produtos/{id}")
    @ApiOperation(value = "Retorna um produto unico.")
    public Produto exibeProdutoUnico(@PathVariable long id) {
        return produtoRepository.findById(id);
    }

    @PostMapping("/produtos/criar")
    @ApiOperation(value = "Salva um produto.")
    public Produto salvaProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    @DeleteMapping("/produtos/deletar/{id}")
    @ApiOperation(value = "Deleta um produto.")
    public void deletaProduto(@PathVariable long id) {
        produtoRepository.deleteById(id);
    }


    @PutMapping("/produtos/atualizar")
    @ApiOperation(value = "Atualiza um produto.")
    public Produto atualizaProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }
}
