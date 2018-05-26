package br.iesb.meuprograma.dados;

import java.io.InputStream;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean
public class FileDownloadView {
        private StreamedContent file;
        public FileDownloadView() {        
        InputStream stream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/application/combo.zip");
        file = new DefaultStreamedContent(stream, "application/zip", "Combo.zip");
    }
    public StreamedContent getFile() {
        return file;
    }  
}

