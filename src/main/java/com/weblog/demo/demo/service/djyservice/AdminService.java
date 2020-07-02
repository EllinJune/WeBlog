package com.weblog.demo.demo.service.djyservice;
import com.weblog.demo.demo.mapper.djymapper.AdminMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Service
public class AdminService {
    @Resource
    private AdminMapper adminMapper;
    public boolean doDeleteArticles(int id){
        boolean flag=false;
        try {
            int r= adminMapper.deleteArticles(id);
            if(r>0){
                flag=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            //记录日志，写到文件中进行保存
        }
        return flag;
    }

    public boolean doDeletePhotos(int id){
        boolean flag=false;
        try {
            int r=adminMapper.deletePhotos(id);
            if(r>0){
                flag=true;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return flag;
    }
    public boolean doDeleteComments (int id)
    {
        boolean flag=false;
        try {
            int r=adminMapper.deleteComments(id);
            if(r>0){
                flag=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            //记录日志，写到文件中进行保存
        }
        return flag;
    }
    public List<Map<String,Object>> doArticleInfo()
    {
        List<Map<String,Object>> list=null;
        try {
            list= adminMapper.articleInfo();
        } catch (Exception e) {
            e.printStackTrace();
            //记录日志，写到文件中进行保存
        }
        return list;
    }
    public List<Map<String,Object>> doPhotoInfo()
    {
        List<Map<String,Object>> list=null;
        try {
            list= adminMapper.photoInfo();
        } catch (Exception e) {
            e.printStackTrace();
            //记录日志，写到文件中进行保存
        }
        return list;
    }
    public List<Map<String,Object>> doCommentInfo()
    {
        List<Map<String,Object>> list=null;
        try {
            list= adminMapper.commentInfo();
        } catch (Exception e) {
            e.printStackTrace();
            //记录日志，写到文件中进行保存
        }
        return list;
    }
}
