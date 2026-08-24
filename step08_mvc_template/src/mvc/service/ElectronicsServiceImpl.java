package mvc.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import mvc.dto.Electronics;
import mvc.exception.DuplicateModelNoException;
import mvc.exception.ElectronicsArrayBoundsException;
import mvc.exception.SearchNotFoundException;

/**
 * 전자제품에 관련된 기능을 담당할 클래스
 */

public class ElectronicsServiceImpl implements ElectronicsService {
	
	private static ElectronicsService instance = new ElectronicsServiceImpl(); 
    private static final int MAX_SIZE=10;
    List<Electronics> list = new ArrayList<Electronics>();
    
    
    /** 
     * 외부에서 객체 생성안됨. 
     * InitInfo.properties파일을 로딩하여  List에 추가하여
     * 초기치 데이터를 만든다.
     * 
     */
    private ElectronicsServiceImpl() {
    	System.out.println("**private constructor init.....");
    	ResourceBundle rb = ResourceBundle.getBundle("InitInfo");//InitInfo.properties
        for(String key : rb.keySet()) {
     	  String value =  rb.getString(key); //100,\uC120\uD48D\uAE30,35000,\uC0BC\uC131 \uC120\uD48D\uAE30
     	   String data[] = value.split(",");
     	   System.out.println(key +" = " + value);
     	  
     	     list.add(new Electronics( Integer.parseInt(data[0]) ,data[1],   
     	    		 Integer.parseInt( data[2]), data[3]) );
     	  
        }
        
        System.out.println(list);
      
    }
    
    public static ElectronicsService getInstance() {
		return instance;
	}

	@Override
	public void insert(Electronics electronics) 
			  throws ElectronicsArrayBoundsException, DuplicateModelNoException {
		if(list.size()>=MAX_SIZE) {
			throw new ElectronicsArrayBoundsException("배열의 길이가 벗어나 더 이상 등록할수 없습니다.");
		}
		
		try {
			//중복체크 
			searchByModelNo(electronics.getModelNo());	
			throw new DuplicateModelNoException("중복");
		} catch (SearchNotFoundException e) {
			list.add(electronics);	
		}
//		for (Electronics el : list) {
//			if(electronics.getModelNo()==el.getModelNo()) {
//				throw new DuplicateModelNoException("중복");
//			}
//		}
//		list.add(electronics);
	}

	@Override
	public List<Electronics> selectAll() {
		
		return list;
	}

	@Override
	public Electronics searchByModelNo(int modelNo) throws SearchNotFoundException {
		for(Electronics el:list) {
			if(modelNo == el.getModelNo()) {
				return el;
			}
		}
		throw new SearchNotFoundException(modelNo+"는 없는 모델번호로 검색할 수 없습니다. ");
	}

	@Override
	public void update(Electronics electronics) throws SearchNotFoundException {
		Electronics el =searchByModelNo(electronics.getModelNo());
		el.setModelDetail(electronics.getModelDetail());
	}

	@Override
	public void delete(int modelNo) throws SearchNotFoundException {
		Electronics el = searchByModelNo(modelNo);
		list.remove(el);
	}

	@Override
	public List<Electronics> selectSortByPrice() {
		List<Electronics> list = new ArrayList<>(this.list);
//		Collections.sort(list);
		Collections.sort(list, ((o1, o2) ->{
			
			if (o1.getModelPrice() != o2.getModelPrice()){
				return o1.getModelPrice()-o2.getModelPrice();
			}else {
				return o1.getModelNo() - o2.getModelNo();
			}
		}
		));
		return list;
	}
    
} // 클래스 끝 