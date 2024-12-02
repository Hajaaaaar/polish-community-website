package com.example.polishCommunity.service;

import com.example.polishCommunity.model.Rights;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RightsService {
    private List<Rights> rightsList;
    public RightsService(){
            rightsList = new ArrayList<Rights>();
            rightsList.add(new Rights("Supporting Integration through Rights and Responsibilities in Wales",
                    "In seeking to become a Nation of Sanctuary, as well as through implementing the Anti Racist Wales Action Plan, the Welsh Government is seeking to eliminate inequalities and support integration. For people to fully integrate with Welsh communities, they need to understand their rights and responsibilities. Host community members equally have responsibilities to follow the law, engage with democratic processes and participate in local communities. Individuals also need to be able to exercise their rights to ensure they have the safety net which is sometimes required. This is why advice services and awareness-raising activities can play a critical role in supporting integration.",
                    "Awareness of rights and responsibilities will support new migrants to build social connections and awareness of Welsh systems more quickly. Rights and responsibilities establish a common framework for interactions between all individuals in a community. It is therefore important that new migrants are supported to understand these as soon as possible.",
                    "https://www.gov.wales/migrant-integration-framework-html#135686"));
    }

    public List<Rights> getRightsList() {
        return rightsList;
    }

    public Rights getRightById(int id){
        return rightsList
    }
}
