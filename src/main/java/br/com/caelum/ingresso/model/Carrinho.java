package br.com.caelum.ingresso.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;


@Component
@SessionScope
public class Carrinho {
	
	private Set<Ingresso> ingressos = new HashSet<Ingresso>();
	
	
	public Set<Ingresso> getIngressos() {
		return ingressos;
	}

	public void setIngressos(Set<Ingresso> ingressos) {
		this.ingressos = ingressos;
	}

	public void add(Ingresso ingresso){
		ingressos.add(ingresso);
	}
	
	public boolean isSelecionado(Lugar lugar){
		return ingressos.stream().map(Ingresso::getLugar).anyMatch(l -> l.equals(lugar));
	}
	
	public BigDecimal getTotal(){
		return ingressos.stream().map(Ingresso::getPreco).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
	}

}
