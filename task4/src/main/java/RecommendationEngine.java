import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class RecommendationEngine {
    public static void main(String[] args) {
        try {
            DataModel model = new FileDataModel(new File("data/ratings.csv"));

            UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
            UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, similarity, model);

            GenericUserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);

            int userId = 1; // Change this to test with different user IDs
            List<RecommendedItem> recommendations = recommender.recommend(userId, 3);

            for (RecommendedItem item : recommendations) {
                System.out.println("Recommended Item ID: " + item.getItemID() + " | Score: " + item.getValue());
            }
        } catch (IOException | TasteException e) {
            e.printStackTrace();
        }
    }
}
